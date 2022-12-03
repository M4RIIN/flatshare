import { ColocationService } from './../../services/colocation.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  constructor(private router: Router,
    private colocationService:ColocationService) {}

  ngOnInit() {}
  onLogin() {
    localStorage.setItem('isLoggedin', 'true');
    this.colocationService.loadColocation();
    this.router.navigate(['/dashboard']);
  }
}
