import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Colocation } from 'src/assets/models/rest';

@Injectable({
  providedIn: 'root'
})
export class ColocationService {

  constructor(private _httpClient: HttpClient) { }

  getColocation():Observable<Colocation>{
    return this._httpClient.get<any>("http://192.168.1.91:8080/colocation?uuid=69e349a5-edca-49d7-8876-d2a5b78745ea");
  }
}
