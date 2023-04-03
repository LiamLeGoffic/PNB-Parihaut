import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: any;
  password: any;
  msgErr: any;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.username = "";
    this.password = "";
  }

  onSubmit() {
    this.authService.login(this.username, this.password).subscribe(result => {
      if (result && result.token) {
        localStorage.setItem('currentUser', JSON.stringify({ username: this.username, token: result.token }));
        this.router.navigate(['/home']);
      }
    });
  }
}
