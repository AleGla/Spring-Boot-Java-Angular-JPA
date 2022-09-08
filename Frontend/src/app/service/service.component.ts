import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { People } from '../models/People';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {


  constructor(private http: HttpClient) { }

  private URL = "http://localhost:8080/";
  private PATH_ALLPEOPLE = "allPersons";
  private PATH_FINDBYID = "findPerson";
  private PATH_ADD = "addPerson";
  private PATH_UPDATE = "updatePerson";
  private PATH_DELETE = "deletePerson";
  private PATH_ORDERLOWTOHIGHMONEY = "orderLowToHighMoney";
  private PATH_ORDERHIGHTOLOWMONEY = "orderHighToLowMoney";
  private PATH_ORDERLOWTOHIGHAGE = "orderLowToHighAge";
  private PATH_ORDERHIGHTOLOWAGE = "orderHighToLowAge";
  private PATH_FINDPERSONBYNATIONALITY = "findPersonByNationality";
  private PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHMONEY = "findPersonByNationalityAndOrderLowToHighMoney";
  private PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWMONEY = "findPersonByNationalityAndOrderHighToLowMoney";
  private PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHAGE = "findPersonByNationalityAndOrderLowToHighAge";
  private PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWAGE = "findPersonByNationalityAndOrderHighToLowAge";
  private PATH_FINDAVAILABLEPERSONTOTRANSFER = "findPersonsAvailableToTransfer";
  private PATH_MONEYTRANSFER = "moneytransfer";

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
    return this.http.post<Object>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHMONEY, obj);
   }

   findPersonByNationalityAndOrderHighToLowMoney(obj: object){
    return this.http.post<Object>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWMONEY, obj);
   }

   findPersonByNationalityAndOrderLowToHighAge(obj: object){
    return this.http.post<Object>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERLOWTOHIGHAGE, obj);
   }

   findPersonByNationalityAndOrderHighToLowAge(obj: object){
    return this.http.post<Object>(this.URL + this.PATH_FINDPERSONBYNATIONALITYANDORDERHIGHTOLOWAGE, obj);
   }

   findPersonsAvailableToTransfer(obj: object){
    return this.http.post<Object[]>(this.URL + this.PATH_FINDAVAILABLEPERSONTOTRANSFER, obj);
   }

   moneyTransfer(obj: object){
      return this.http.post(this.URL + this.PATH_MONEYTRANSFER, obj);
   }
   
   
}
