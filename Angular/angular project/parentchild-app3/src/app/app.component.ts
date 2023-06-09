import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  parentCount = 0;

  incrementCount() {
    this.parentCount++;
  }

  updateParentCount(count: number) {
    this.parentCount = count;
  }
}