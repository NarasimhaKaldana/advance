import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  @Input() childCount !: number;
  @Output() countChanged = new EventEmitter<number>();

  decrementCount() {
    if (this.childCount > 0) {
      this.childCount--;
      this.countChanged.emit(this.childCount);
    }
  }
}