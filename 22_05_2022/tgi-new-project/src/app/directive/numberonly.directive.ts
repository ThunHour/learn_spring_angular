import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[numbersOnly]',
})
export class NumberOnlyDirective {
  constructor(private _el: ElementRef) {}
  @HostListener('input', ['$event']) onInputChange(event: {
    stopPropagation: () => void;
  }): any {
    const initialValue = this._el.nativeElement.value;
    this._el.nativeElement.value = initialValue.replace(/[^0-9]*/g, '');
    if (initialValue !== this._el.nativeElement.value) {
      event.stopPropagation();
    }
  }
}
