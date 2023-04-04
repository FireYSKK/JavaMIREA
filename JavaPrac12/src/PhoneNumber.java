public class PhoneNumber {
    String phoneNumber;

    public PhoneNumber(){}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumber(String phoneNumber) {
        // Постановка "-" в нужнах местах
        phoneNumber = new StringBuffer(phoneNumber).insert(phoneNumber.length() - 4, "-").toString();
        phoneNumber = new StringBuffer(phoneNumber).insert(phoneNumber.length() - 8, "-").toString();
        phoneNumber = new StringBuffer(phoneNumber).insert(phoneNumber.length() - 12, " ").toString();

        // Добавить "+" в начало и уменьшить первый символ на 1
        if (phoneNumber.charAt(0) != '+') {
            phoneNumber =  phoneNumber.replace(phoneNumber.charAt(0), (char) (((int) phoneNumber.charAt(0)) - 1));
            phoneNumber = new StringBuffer(phoneNumber).insert(0, "+").toString();
        }
        this.phoneNumber = phoneNumber;
    }

    public void test() {
        PhoneNumber phoneNumber1 = new PhoneNumber("+79175655655");
        System.out.println(phoneNumber1.getPhoneNumber());

        PhoneNumber phoneNumber2 = new PhoneNumber("+104289652211");
        System.out.println(phoneNumber2.getPhoneNumber());

        PhoneNumber phoneNumber3 = new PhoneNumber("89175655655");
        System.out.println(phoneNumber3.getPhoneNumber());
    }
}
