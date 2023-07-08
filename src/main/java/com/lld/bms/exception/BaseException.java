package com.lld.bms.exception;

public class BaseException extends Exception{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private Long id;
  
  public BaseException() {
    super();
  }

  public BaseException(String message, Throwable cause, Long id) {
    super(message, cause);
    this.id = id;
  }

  public BaseException(String message) {
    super(message);
  }
  
  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }
}
