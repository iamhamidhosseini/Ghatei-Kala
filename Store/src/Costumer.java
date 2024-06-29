

/**
 *
 * @author 66490812
 */
public class Costumer {

        private String name;
        private String family;
        private String age;
        private String phone ;
        private String id;
        private String email;
        private String password;
        private String balance;
        
        public Costumer(String name,String family,String age,String phone,String id,String email,String password, String balance){
            this.name=name;
            this.family=family;
            this.age=age;
            this.phone=phone;
            this.id=id;
            this.email=email;
            this.password=password;
            this.balance = balance;
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
        
        public String getBalance(){
            return balance;
        }
        
        public void setBalance(String balance){
            this.balance = balance;
        }
        
        @Override
        public String toString (){
            return getID();
        }
        
}
