enum UserType {
  Student = "STUDENT",
  Professor = "PROFESSOR"
}

export class User {
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  nationalCode: string;
  userType: UserType;
  emailId: string;

}
