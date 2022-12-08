import { ColocationService } from './../../../services/colocation.service';
import { Component, OnInit, Output, EventEmitter, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TopNavComponent implements OnInit {
  @Output() sideNavToggled = new EventEmitter<void>();

  colocationName:string = "";
  

  constructor(private readonly router: Router,
    public colocationService:ColocationService,
    private cdr:ChangeDetectorRef) {}

  ngOnInit() {
    this.getColocationName();
  }

  getColocationName(){
    this.colocationService.getColocation().subscribe(c =>{
      this.colocationName = c.name;
      this.cdr.markForCheck();
    })
  }

  toggleSidebar() {
    this.sideNavToggled.emit();
  }

  onLoggedout() {
    localStorage.removeItem('isLoggedin');
    this.router.navigate(['/login']);
  }
}
