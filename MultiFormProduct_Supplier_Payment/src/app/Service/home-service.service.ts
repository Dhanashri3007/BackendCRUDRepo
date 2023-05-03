import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {

  constructor(private http :HttpClient) { }
  
  postMultiFormData(multi:any)
  {
    return this.http.post("http://localhost:8080/addProductData",multi)
  }
}
