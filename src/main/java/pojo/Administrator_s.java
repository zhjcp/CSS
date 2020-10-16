package pojo;

public class Administrator_s {
        String id;
        String name;
        String pwd;
        String sex;
        String phone;
        String email;

        public Administrator_s() {
        }

        public Administrator_s(String id, String name, String pwd, String sex, String phone, String email) {
                this.id = id;
                this.name = name;
                this.pwd = pwd;
                this.sex = sex;
                this.phone = phone;
                this.email = email;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPwd() {
                return pwd;
        }

        public void setPwd(String pwd) {
                this.pwd = pwd;
        }

        public String getSex() {
                return sex;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
