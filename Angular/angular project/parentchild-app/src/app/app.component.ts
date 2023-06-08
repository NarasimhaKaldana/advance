import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',     
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'parentchild-app';
  enterName="Narasimha";
  parentData="";
  enterName2="Veera";
  parentData2="";

value="";

transferData(){
  this.parentData=this.enterName;
 
}
transferData2(){
  this.parentData2=this.enterName2;
 
}
sendData(value:string){
  this.value=value;
}


}
