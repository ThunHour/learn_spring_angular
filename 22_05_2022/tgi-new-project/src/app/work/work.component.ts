import { Component, Input, Output } from '@angular/core';
import { EventEmitter } from 'stream';

@Component({
  selector: 'app-work',
  templateUrl: './work.component.html',
  styleUrls: ['./work.component.scss'],
})
export class WorkComponent {
  @Input() passValueTest:any;
  @Output() passDataOut=new EventEmitter();
  customerName = 'Jenh';
  srcImage = 'https://i.ytimg.com/vi/9fUpICk9MuE/hqdefault.jpg';

  // FUNCTION OR METHOD
  clickMe(): void {
    console.log('click me worked');
    this.passDataOut.emit('data from work component');
  }
}
