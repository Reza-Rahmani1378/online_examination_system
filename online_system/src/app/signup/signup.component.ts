import {Component, OnInit} from '@angular/core';
import {User} from "../models/User";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  userTypes = ['PROFESSOR', 'STUDENT']
  types = ['Professor', 'Student']

  private user = new User();

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
  }

  // create the form object.
  form = new FormGroup(
    {
      'firstName': new FormControl('', Validators.required),
      'lastName': new FormControl('', Validators.required),
      'username': new FormControl('', Validators.required),
      'password': new FormControl('', Validators.required),
      'nationalCode': new FormControl('', Validators.required),
      'confirmPassword': new FormControl('', Validators.required),
      'email': new FormControl('', [Validators.required, Validators.email]),
      'userType': new FormControl('Student')
    }
  );


  userForm(UserInformation) {
    let pass = this.password.value;
    let confirmPass = this.confirmPassword.value;

    if (pass === confirmPass) {
      this.user.firstName = this.firstName.value;
      this.user.lastName = this.lastName.value;
      this.user.username = this.username.value;
      this.user.password = pass;
      this.user.email = this.email.value;
      this.user.nationalCode = this.nationalCode.value;
      this.user.userType = this.userType.value;
      console.log(this.user);

      this.userService.saveUserDetails(this.user).subscribe(
        response => {
          console.log("result is :" + response);

          if (response > 0) {
            alert("You are Signup Successfully.");
            this.router.navigate(['/login']);

          } else {
            alert("Error Occur whiling Register User Please Try after sometime1111.");
          }
        } /*,
        error => {
          alert("Error Occur whiling Register User Please Try after sometime.");
        }*/
      );
    } else {
      alert("Password and ConfirmPass Are not matched");
    }


  }


  get firstName() {
    return this.form.get('firstName');
  }

  get lastName() {
    return this.form.get('lastName');
  }

  get password() {
    return this.form.get('password');
  }

  get confirmPassword() {
    return this.form.get('confirmPassword');
  }

  get username() {
    return this.form.get('username');
  }

  get nationalCode() {
    return this.form.get('nationalCode');
  }

  get userType() {
    return this.form.get('userType');
  }

  get email() {
    return this.form.get('email');
  }

}
