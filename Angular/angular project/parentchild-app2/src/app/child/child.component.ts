import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {

  childItem: string | undefined;
  @Output() childEvent = new EventEmitter<string>();

  addChildItem() {
    this.childEvent.emit(this.childItem);
    this.childItem = '';
  }

}