import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {
  newTask: string = '';

  @Output() addTask = new EventEmitter<string>();

  onSubmit() {
    this.addTask.emit(this.newTask);
    this.newTask = '';

}
}
