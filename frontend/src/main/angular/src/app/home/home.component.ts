import { Colocation } from './../../assets/models/rest';
import { ColocationService } from './../services/colocation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  colocation: Colocation = new Colocation();

  constructor(private colocationService:ColocationService) { }

  ngOnInit(): void {
    this.colocationService.getColocation().subscribe(data=>{
     this.colocation = data;
    })
  }

}
