//package bdaytemplate.dto;
//
//
//
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@NoArgsConstructor
//public class EmailRequest {
//
//    private  int employeeid;
//    private String name;
//    private String email;
//    private Date birthdate;
//
//    public EmailRequest(int employeeid, String name, String email, Date birthdate) {
//        this.employeeid = employeeid;
//        this.name = name;
//        this.email = email;
//        this.birthdate = birthdate;
//    }
//
////    public EmailRequest(EmailRequestDTOBuilder emailRequestDTOBuilder) {
////        this.employeeid = emailRequestDTOBuilder.employeeid;
////        this.name = emailRequestDTOBuilder.name;
////        this.email = emailRequestDTOBuilder.email;
////        this.birthdate = emailRequestDTOBuilder.birthdate;
////    }
////    public static EmailRequestDTOBuilder builder(){
////        return new EmailRequestDTOBuilder();
////    }
//    public int getEmployeeId() {
//        return employeeid;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//
//    public Date getBirthdate() {
//        return birthdate;
//    }
//
////    public static class EmailRequestDTOBuilder {
////        private  int employeeid;
////        private  String name;
////        private  String email;
////        private  Date birthdate;
////
////        public EmailRequestDTOBuilder() {
////        }
////
////        public EmailRequestDTOBuilder employeeId(int employeeid) {
////            this.employeeid = employeeid;
////            return this;
////        }
////
////        public EmailRequestDTOBuilder name(String name) {
////            this.name = name;
////            return this;
////        }
////
////        public EmailRequestDTOBuilder email(String email) {
////            this.email = email;
////            return this;
////        }
////        public EmailRequestDTOBuilder birthdate(Date birthdate) {
////            this.birthdate = birthdate;
////            return this;
////        }
////        public EmailRequest build() {
////            return new EmailRequest(this);
////        }
////
////    }
//@Override
//public String toString() {
//    return "EmailRequest{" +
//            "name='" + name + '\'' +
//            ", email='" + email + '\'' +
//            "employeeid='" + employeeid + '\'' +
//            ", birthdate='" + birthdate + '\'' +
//            '}';
//}
//}
package bdaytemplate.dto;

public class EmailRequest {
    private int employeeid;
    private String name;
    private String birthdate;
    private String email;
    private String reporting_manager;

    public EmailRequest() {
    }

    public EmailRequest(int employeeid, String name, String birthdate, String email, String reporting_manager) {
        this.employeeid = employeeid;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.reporting_manager = reporting_manager;
    }


    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReporting_manager() {
        return reporting_manager;
    }

    public void setReporting_manager(String reporting_manager) {
        this.reporting_manager = reporting_manager;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "employeeid=" + employeeid +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email='" + email + '\'' +
                ", reporting_manager='" + reporting_manager + '\'' +
                '}';
    }
}

