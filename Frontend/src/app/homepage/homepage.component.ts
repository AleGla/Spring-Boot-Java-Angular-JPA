import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service/service.component';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(public service: ServiceService) { }

  ngOnInit() {
    console.log("EXECUTE HOME PAGE");
 //   this.testEndpoint();
  }

  





}
