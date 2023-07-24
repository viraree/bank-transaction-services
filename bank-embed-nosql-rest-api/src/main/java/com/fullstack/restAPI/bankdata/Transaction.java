package com.fullstack.restAPI.bankdata;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
//import io.swagger.model.User;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-07-24T14:34:31.042041354Z[GMT]")


public class Transaction   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("user_uid")
  private String userUid = null;

  @JsonProperty("uid")
  private String uid = null;

  @JsonProperty("currency_amount")
  private String currencyAmount = null;

  @JsonProperty("eur_amount")
  private BigDecimal eurAmount = null;

  @JsonProperty("value_date")
  private String valueDate = null;

  @JsonProperty("month_num")
  private Integer monthNum = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("User")
  private User user = null;

  public Transaction id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/

  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transaction userUid(String userUid) {
    this.userUid = userUid;
    return this;
  }



  
  public String getUserUid() {
    return userUid;
  }

  public void setUserUid(String userUid) {
    this.userUid = userUid;
  }

  public Transaction uid(String uid) {
    this.uid = uid;
    return this;
  }


    public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public Transaction currencyAmount(String currencyAmount) {
    this.currencyAmount = currencyAmount;
    return this;
  }

  
    public String getCurrencyAmount() {
    return currencyAmount;
  }

  public void setCurrencyAmount(String currencyAmount) {
    this.currencyAmount = currencyAmount;
  }

  public Transaction eurAmount(BigDecimal eurAmount) {
    this.eurAmount = eurAmount;
    return this;
  }


    @Valid
    public BigDecimal getEurAmount() {
    return eurAmount;
  }

  public void setEurAmount(BigDecimal eurAmount) {
    this.eurAmount = eurAmount;
  }

  public Transaction valueDate(String valueDate) {
    this.valueDate = valueDate;
    return this;
  }

  /**
   * Get valueDate
   * @return valueDate
   **/

  
    @Valid
    public String getValueDate() {
    return valueDate;
  }

  public void setValueDate(String valueDate) {
    this.valueDate = valueDate;
  }

  public Transaction monthNum(Integer monthNum) {
    this.monthNum = monthNum;
    return this;
  }

  /**
   * Get monthNum
   * @return monthNum
   **/

  
    public Integer getMonthNum() {
    return monthNum;
  }

  public void setMonthNum(Integer monthNum) {
    this.monthNum = monthNum;
  }

  public Transaction description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/

  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Transaction user(User user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/

  
    @Valid
    public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.userUid, transaction.userUid) &&
        Objects.equals(this.uid, transaction.uid) &&
        Objects.equals(this.currencyAmount, transaction.currencyAmount) &&
        Objects.equals(this.eurAmount, transaction.eurAmount) &&
        Objects.equals(this.valueDate, transaction.valueDate) &&
        Objects.equals(this.monthNum, transaction.monthNum) &&
        Objects.equals(this.description, transaction.description) &&
        Objects.equals(this.user, transaction.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userUid, uid, currencyAmount, eurAmount, valueDate, monthNum, description, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userUid: ").append(toIndentedString(userUid)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    currencyAmount: ").append(toIndentedString(currencyAmount)).append("\n");
    sb.append("    eurAmount: ").append(toIndentedString(eurAmount)).append("\n");
    sb.append("    valueDate: ").append(toIndentedString(valueDate)).append("\n");
    sb.append("    monthNum: ").append(toIndentedString(monthNum)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
