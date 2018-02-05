package com.syh.deeepoch;

/**
 * Created by 孙应恒 on 2018/2/5.
 * Description:
 */

public class EpochEntity {
  private String eString;
  private int eInt;

  public EpochEntity(String eString, int eInt) {
    this.eString = eString;
    this.eInt = eInt;
  }

  public String geteString() {
    return eString;
  }

  public void seteString(String eString) {
    this.eString = eString;
  }

  public int geteInt() {
    return eInt;
  }

  public void seteInt(int eInt) {
    this.eInt = eInt;
  }
}
