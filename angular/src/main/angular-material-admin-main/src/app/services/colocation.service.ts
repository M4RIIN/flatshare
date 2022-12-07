

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Colocation } from 'src/assets/models/rest';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ColocationService {

  private colocation$: Observable<Colocation>;
  public userConnected:string;

 private constructor(private _httpClient: HttpClient) { 
    this.loadColocation();
  }

  loadColocation():void{
    this.userConnected = localStorage.getItem("userConnected");
    this.colocation$ =  this._httpClient.get<any>(environment.baseUrl + "colocation?uuid=69e349a5-edca-49d7-8876-d2a5b78745ea");
  }

  getColocation():Observable<Colocation>{
    return this.colocation$;
  }
}
