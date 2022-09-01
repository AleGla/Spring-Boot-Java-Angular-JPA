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
    

  getAllPeople() {
    return this.http.get<People[]>(this.URL + this.PATH_ALLPEOPLE);
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

   

 

}
