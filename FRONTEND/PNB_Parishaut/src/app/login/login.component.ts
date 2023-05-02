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

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.username = '';
    this.password = '';
  }

  authenticate() {
    this.authService.login(this.username, this.password).subscribe(result => {
      if (result != null) {
        localStorage.setItem('currentUser', JSON.stringify({ username: this.username, token: result }));
        this.router.navigateByUrl('');
      }
    },
    err => (console.log(err))
    );
  }
}
