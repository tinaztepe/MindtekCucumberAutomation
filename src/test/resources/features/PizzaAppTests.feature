@OMT-7932 @regression
  Feature: Validating pizza application functionalities

    Scenario: Validating place order functionality
      Given user navigates to pizza application
      When user creates pizza order with data
      |Pizza|Small 6 Slices - no toppings|
      |Toppings 1|Mushrooms              |
      |Toppings 2|Extra Cheese           |
      |Quantity  |1                      |
      |Name      |Patel Harsh            |
      |Email     |patel@gmail.com        |
      |Phone     |3123121212             |
      |Payment Type|Credit Card          |
      Then user validates that order is created with success message "Thank you for your order! TOTAL: " "<Pizza>"

     #Map<String,Object> map=new HashMap();
     # map.put("Pizza", "small 6 slices -no toppings")
  #map.put("Toppings 1", "Mushrooms")



      #map=[Pizza=small 6 slices -no toppings,Toppings 1=Mushrooms,Toppings 2=Extra cheese,Quantity=1,Name=PatelHarsh,Email=patel@gmail.com,Phone=3123121212