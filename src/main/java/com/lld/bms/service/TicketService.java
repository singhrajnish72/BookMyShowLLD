package com.lld.bms.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.lld.bms.dto.TicketRequestDTO;
import com.lld.bms.exception.BaseException;
import com.lld.bms.models.Chair;
import com.lld.bms.models.ChairStatus;
import com.lld.bms.models.Screen;
import com.lld.bms.models.ScreenChair;
import com.lld.bms.models.Ticket;
import com.lld.bms.models.TicketStatus;
import com.lld.bms.models.User;
import com.lld.bms.repository.ScreenChairRepository;
import com.lld.bms.repository.ScreenChairTypeRepository;
import com.lld.bms.repository.ScreenRepository;
import com.lld.bms.repository.SeatRepository;
import com.lld.bms.repository.TicketRepository;
import com.lld.bms.repository.UserRepository;

public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;
  
  @Autowired
  private SeatRepository seatRepository;
  
  @Autowired
  private ScreenRepository screenRepository;
  
  @Autowired
  private ScreenChairTypeRepository screenChairTypeRepository;
  
  @Autowired
  private ScreenChairRepository screenChairRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  
  //1. propagation - it means create new Transcation if required
  //2. SERIALIZABLE - It is a isolation mechanism which allow only one transaction to perform read and write
  //                  by acquiring row level or table lock.
  //3. If transcation T1 has acquired the lock of seat s1, s2 then T2 transcation has to 
  //   wait.
  //4. We should not hold the lock until user book the ticket. Because it will impact
  //   the performance. All the other user has to wait to check seats status until
  //     the current user completes it's payment or payment got failed.
  //5. Instead of that we acquire lock which booking the ticket and change the status of
  //   of ticket to LOCKED . SO Next user when try to book the same ticket he would get
  //   error msg because the status of that seat would be locked.
  @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
  public Ticket bookTicket(TicketRequestDTO ticketRequestDTO) throws BaseException {
    
    /* Steps to Book ticket */
    //a. fetch all chairs from chair repository by passing list of chairIds
    //b. fetch screen details from screen repository by passing screenId
    //c. fetch screenchair fetch listofchairs and screen and get screenchair mapped rows
    //d. from mapped rows check the chairstatus
    //e. if available apply lock and change chairstatus to booked release lock 
    //  e.1 if all seats are available book ticket
    //  e.2 if partial seats available throw exception
    
   List<Chair> chairs = seatRepository.findAllById(ticketRequestDTO.getChairIds());
   Optional<Screen> screen =   screenRepository.findById(ticketRequestDTO.getScreenId());
   
   if(!screen.isPresent()) {
     throw new BaseException("Given show is not present");
   }
   
   List<ScreenChair> screenChairsList =  screenChairRepository.findAllByChairAndScreen(chairs, screen.get());
   

   for(ScreenChair screenChair : screenChairsList) {
       //we can add OR conditon where we could check the b8ookedtime > 20sec like thing
       if(!screenChair.getChairStatus().equals(ChairStatus.AVAILABLE)) {
           throw new BaseException("error while booking ticket");
       }
   }
   
   for(ScreenChair screenChair : screenChairsList) {
     screenChair.setChairStatus(ChairStatus.LOCKED);
     screenChair.setLockedAt(LocalTime.now());
     screenChairRepository.save(screenChair);
   }
   
   Optional<User> user = userRepository.findById(ticketRequestDTO.getUserId());
   
   
   if(!user.isPresent()) {
       throw new BaseException("invalid user");
   }
   
   Ticket ticket = new Ticket();
   
   ticket.setAmount(100);
   ticket.setAuditorium(screen.get().getAuditorium());
   ticket.setBookedChairs(chairs);
   ticket.setBookingTime(LocalTime.now());
   ticket.setTicketStatus(TicketStatus.PROCESSING);
   ticket.setUser(user.get());
   ticket.setTicketNo(new Random().nextInt());
   
   ticketRepository.save(ticket);
  
   
   return ticket;
  }
}
