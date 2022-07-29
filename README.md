# ParkMyCar

For now i did everything in one class.(As i didnt get time, I hope you will Understand)
So all the testcase you have ask you can run those by giving the values in console.

Commands given below:
$ create_parking_lot 6
Created a parking lot with 6 slots

$ park GJ-01-HH-1234 White
Allocated slot number: 1

$ park GJ-01-HH-9999 White
Allocated slot number: 2

$ park GJ-01-BB-0001 Black
Allocated slot number: 3

$ park GJ-01-HH-7777 Red
Allocated slot number: 4

$ park GJ-01-HH-2701 Blue
Allocated slot number: 5

$ park GJ-01-HH-3141 Black
Allocated slot number: 6

$ leave 4
Slot number 4 is free

$ status
Slot No. Registration No. Colour
1 GJ-01-HH-1234 White
2 GJ-01-HH-9999 White
3 GJ-01-BB-0001 Black
5 GJ-01-HH-2701 Blue
6 GJ-01-HH-3141 Black

$ park GJ-01-P-333 White
Allocated slot number: 4


$ park DL-12-AA-9999 White
Sorry, parking lot is full

$ registration_numbers_for_cars_with_colour White
GJ-01-HH-1234, GJ-01-HH-9999, GJ-01-P-333

$ slot_numbers_for_cars_with_colour White
1, 2, 4

$ slot_number_for_registration_number GJ-01-HH-3141
6

$ slot_number_for_registration_number GJ-04-AY-1111
Not found

$ exit
