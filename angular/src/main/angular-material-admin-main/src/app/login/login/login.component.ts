import { ColocationService } from './../../services/colocation.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { I } from '@angular/cdk/keycodes';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  pseudo:string = "";
  constructor(private router: Router,
    private colocationService:ColocationService) {}

  ngOnInit() {}
  onLogin() {
    if(this.pseudo !== ""){
      localStorage.setItem('isLoggedin', 'true');
      localStorage.setItem('userConnected', this.pseudo);
      this.colocationService.loadColocation();
      this.router.navigate(['/dashboard']);
    }

  }
}
