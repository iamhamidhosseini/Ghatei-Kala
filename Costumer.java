public class Costumer {

    private String name;
    private String family;
    private String age;
    private String phone ;
    private String id;
    private String email;
    private String password;
    public Costumer(String name,String family,String age,String phone,String id,String email,String password){
        this.name=name;
        this.family=family;
        this.age=age;
        this.phone=phone;
        this.id=id;
        this.email=email;
        this.password=password;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }
    @Override
    public String toString (){
        return getID();
    }
}

