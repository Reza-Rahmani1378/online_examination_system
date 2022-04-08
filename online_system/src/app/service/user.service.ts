import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {User} from "../models/User";
import {Observable} from "rxjs";
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // Base URL
  private baseUrl = "http://localhost8080/api"

  constructor(private http: HttpClient, private router: Router) {
  }

  saveUserDetails(userDetail: User): Observable<any> {
    let url = this.baseUrl + 'saveUser';
    return this.http.post(url, userDetail);

  }

  login(userDetail: User): Observable<any> {
    let url = this.baseUrl + 'login';
    return this.http.post(url, userDetail);
  }


  logout() {
    localStorage.removeItem("token");
    this.router.navigate(['']);
  }

  /*
  * Check if the User is logged in .
  * */
  isLoggedIn() {
    let jwtHelper = new JwtHelperService();

    let token = localStorage.getItem("token");

    if (!token) {

      return false;
    }

    if (token) {
      let expirationDate = jwtHelper.getTokenExpirationDate(token);

      let isExpired = jwtHelper.isTokenExpired(token);

      return !isExpired;
    }
  }
}
