package com.cin7.main;

import java.util.Scanner;

public class ParkMyCar {

	      
	ParkMyCar pk[];      
	int counter = 0;      
	Integer[] record;      
	int recordCount = 0;

	      
	private int slot;      
	private String registrationNo;      
	private String color;

	      public int getSlot() {
            return slot;
      }

	      public void setSlot(int slot) {
            this.slot = slot;
      }

	      public String getRegistrationNo() {
            return registrationNo;
      }

	      public void setRegistrationNo(String registrationNo) {
            this.registrationNo = registrationNo;
      }

	      public String getColor() {
            return color;
      }

	      public void setColor(String color) {
            this.color = color;
      }

	      public ParkMyCar(int slot, String registrationNo, String color) {
            super();
            this.slot = slot;
            this.registrationNo = registrationNo;
            this.color = color;
      }

	      public ParkMyCar() {
      }

	      public static void main(String args[]) {
            ParkMyCar mm = new ParkMyCar();
            Scanner sc = new Scanner(System.in);
            Boolean res = true;
            do {
                  String command;
                  command = sc.nextLine();
                  String kk[] = command.split(" ");
                  if (kk[0].contains("create")) {
                        mm.createSlot(Integer.valueOf(kk[1]));
                        System.out.println("Created parking lot with " + kk[1] + " slots");
                  } else if (kk[0].contains("park")) {
                        mm.parkCar(kk[1], kk[2]);

                  }

                  else if (kk[0].contains("leave")) {
                        mm.remove(Integer.valueOf(kk[1]));

                  } else if (kk[0].contains("status")) {
                        mm.showStatus();

                  } else if (kk[0].contains("exit")) {
                        res = false;
                  } else if (kk[0].contains("cars_with_colour")) {
                        mm.carWithColor(kk[0], kk[1]);
                  } else if (kk[0].contains("slot_number_for_registration_number")) {
                        mm.showSlotByRN(kk[1]);
                  }

            } while (res);

      }

	      public void showSlotByRN(String registration_number) {

            Boolean flag = true;
            for (int i = 0; i < pk.length; i++) {
                  if (pk[i]!=null &&pk[i].getRegistrationNo().equalsIgnoreCase(registration_number)) {
                        System.out.print(pk[i].getSlot());
                        flag = false;
                  }
            }
            if (flag) {
                  System.out.print("Not found");
            }

      }

	      public void createSlot(int slots) {
            pk = new ParkMyCar[slots];
            record = new Integer[slots];
      }

	      public void showStatus() {
            System.out.println("Slot No. Registration No. Colour");
            for (int i = 0; i < pk.length; i++) {
                  if (pk[i] != null) {
                        System.out.println(pk[i].getSlot() + " " + pk[i].getRegistrationNo() + " " + pk[i].getColor());
                  }
            }

      }

	      public void parkCar(String carNumber, String color) {
            Boolean flag = true;
            for (int i = 0; i < record.length; i++) {
                  if (record[i] != null) {
                        int temp = record[i];
                        pk[record[i]] = new ParkMyCar(++temp, carNumber, color);
                        record[i] = null;
                        flag = false;
                        System.out.println("Allocated slot number:" + temp);
                        break;
                  }

            }
            if (flag) {
                  if (counter == pk.length) {
                        System.out.println("Sorry, parking lot is full");
                  } else if (pk[counter] == null) {
                        int temp = counter;
                        pk[counter] = new ParkMyCar(++temp, carNumber, color);
                        counter++;
                        System.out.println("Allocated slot number:" + temp++);
                  }
            }

      }

	      public void carWithColor(String type, String color) {
            if (type.contains("registration_numbers")) {
                  for (int i = 0; i < pk.length; i++) {
                        if (pk[i]!=null && pk[i].getColor().equalsIgnoreCase(color)) {
                              if (i == 0) {
                                    System.out.print(pk[i].getRegistrationNo());

                              } else {
                                    System.out.print("," + pk[i].getRegistrationNo());
                              }
                        }
                  }

            }

            else if (type.contains("slot_numbers")) {
                  for (int i = 0; i < pk.length; i++) {
                        if (pk[i]!=null &&pk[i].getColor().equalsIgnoreCase(color)) {
                              if (i == 0) {
                                    System.out.print(pk[i].getSlot());

                              } else {
                                    System.out.print("," + pk[i].getSlot());
                              }
                        }
                  }

            }
      }

	      public void remove(int index) {

            int temp = index;
            pk[--temp] = null;
            System.out.println("Slot number " + index + " is free");
            if (!Arrays.asList(record).contains(temp)) {
                  if (recordCount >= pk.length) {
                        recordCount = 0;
                  }
                  record[recordCount] = temp;
                  recordCount++;
            }
      }

}
