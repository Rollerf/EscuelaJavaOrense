import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CuentaBanc } from './modelo/CuentaBanc';

//Objecto que Angular se encarga de instanciar como un Singleton
@Injectable({
  providedIn: 'root'
})
export class CuentasRestService {

  //Infiere / deduce a partir del valor("" es String)
  urlApiRest = "http://localhost:8080/cuentas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private httpCli: HttpClient) { }

  public add(nuevaCuenta: CuentaBanc) : Observable<CuentaBanc>{
    return this.httpCli.post<CuentaBanc>(this.urlApiRest, 
      nuevaCuenta, this.httpOptions);
  }
}

