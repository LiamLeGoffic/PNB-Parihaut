import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post('http://localhost:9000/auth/authenticate', { "username": username, "password": password });// body, { headers });
  }

  register(lastName: string, firstName: string, email: string, phoneNumber: string, username: string, password: string) {
    return this.http.post('http://localhost:9000/auth/register', {
      "lastName": lastName,
      "firstName": firstName, 
      "email": email, 
      "phoneNumber": phoneNumber, 
      "username": username, 
      "password": password
    });
  }
}