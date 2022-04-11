import {Component, OnInit} from '@angular/core';
import {User} from "../models/User";
import {UserService} from "../service/user.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private user = new User();
  private userType: string = null;
  private isConfirmed: boolean;


  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    if (!this.userService.isLoggedIn()) {
      console.log("Fuck You.")
      this.router.navigate(['/login']);
    }
  }

  form = new FormGroup(
    {
      'email': new FormControl('', [Validators.required, Validators.email]),
      'password': new FormControl('', Validators.required)
    }
  );

  login(loginInformation) {
    this.user.email = this.email.value;
    this.user.password = this.password.value;

    this.userService.login(this.user).subscribe(
      (response) => {

        console.log(response);
        let token = response.headers.get('Authorization');
        console.log(token);

        if (response.body.id > 0) {

          localStorage.setItem("token", token);
          localStorage.setItem("id", response.body.id);
          this.userType = response.body.userType;
          this.isConfirmed = response.body.confirmed;
          console.log("User type : " + this.userType + "is confirmed : " + this.isConfirmed);

          if (this.userService.isLoggedIn() && this.isConfirmed) {
            let type: string = this.userType;
            console.log(type)
            switch (type) {
              case 'ADMIN' :
                console.log(type);
                this.router.navigate(['/adminWorkBench']);
                break;
              case 'PROFESSOR' :
                this.router.navigate(['/professorWorkbench']);
                break;
              case 'STUDENT' :
                this.router.navigate(['/studentWorkbench']);
                break;
            }
          }


        }
        if (response.body.id === -1) {
          alert("please register before login Or Invalid combination of Email and password");
        }
      }, error => {
        console.log("Error in Authentication.")
      }
    );
  }


  get email() {
    return this.form.get('email');
  }

  get password() {
    return this.form.get('password');
  }

}
