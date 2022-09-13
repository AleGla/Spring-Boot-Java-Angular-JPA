import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { People } from '../models/People';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {


  constructor(private http: HttpClient) { }

  private URL = "http://localhost:9000/api/service/person";
  private PATH_ALLPEOPLE = "/all";
  private PATH_FINDBYID = "/find";
  private PATH_ADD = "/add";
  private PATH_UPDATE = "/update";
  private PATH_DELETE = "/delete";
  private PATH_ORDERLOWTOHIGHMONEY = "/order/money/lowtohigh";
  private PATH_ORDERHIGHTOLOWMONEY = "/order/money/hightolow";
  private PATH_ORDERLOWTOHIGHAGE = "/order/age/lowtohigh";
  private PATH_ORDERHIGHTOLOWAGE = "/order/age/hightolow";
  private PATH_FINDPERSONBYNATIONALITY = "/find/by/nationality";
  private PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHMONEY = "/order/money/lowtohigh/and/nationality";
  private PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWMONEY = "/order/money/hightolow/and/nationality";
  private PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHAGE = "/order/age/lowtohigh/and/nationality";
  private PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWAGE = "/order/age/hightolow/and/nationality";
  private PATH_FINDAVAILABLEPERSONTOTRANSFER = "/available/transfer";
  private PATH_MONEYTRANSFER = "/transfer";

  getAllPeople() {
    return this.http.get<Object[]>(this.URL + this.PATH_ALLPEOPLE);
  }

  addPerson(obj: object){
    return this.http.post(this.URL + this.PATH_ADD, obj);
  }

  updatePerson(obj: object){
    return this.http.post(this.URL + this.PATH_UPDATE, obj);
  }

  getPersonById(obj: object){
    return this.http.post(this.URL + this.PATH_FINDBYID, obj);
  }

  deletePerson(obj: object){
    return this.http.post(this.URL + this.PATH_DELETE, obj);
  }

   orderLowToHighMoney(){
    return this.http.get<Object[]>(this.URL + this.PATH_ORDERLOWTOHIGHMONEY);
   }

   orderHighToLowMoney(){
    return this.http.get<Object[]>(this.URL + this.PATH_ORDERHIGHTOLOWMONEY);
   }

   orderLowToHighAge(){
    return this.http.get<Object[]>(this.URL + this.PATH_ORDERLOWTOHIGHAGE);
   }

   orderHighToLowAge(){
    return this.http.get<Object[]>(this.URL + this.PATH_ORDERHIGHTOLOWAGE);
   }

   findPersonByNationality(obj: object){
    return this.http.post<Object>(this.URL + this.PATH_FINDPERSONBYNATIONALITY, obj);
   }

   findPersonByNationalityAndOrderLowToHighMoney(obj: object){
    return this.http.post<Object[]>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHMONEY, obj);
   }

   findPersonByNationalityAndOrderHighToLowMoney(obj: object){
    return this.http.post<Object[]>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWMONEY, obj);
   }

   findPersonByNationalityAndOrderLowToHighAge(obj: object){
    return this.http.post<Object[]>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHAGE, obj);
   }

   findPersonByNationalityAndOrderHighToLowAge(obj: object){
    return this.http.post<Object[]>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWAGE, obj);
   }

   findPersonsAvailableToTransfer(obj: object){
    return this.http.post<Object[]>(this.URL + this.PATH_FINDAVAILABLEPERSONTOTRANSFER, obj);
   }

   moneyTransfer(obj: object){
      return this.http.post(this.URL + this.PATH_MONEYTRANSFER, obj);
   }
   
   
}
