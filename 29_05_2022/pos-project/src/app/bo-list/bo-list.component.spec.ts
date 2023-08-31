/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { BoListComponent } from './bo-list.component';

describe('BoListComponent', () => {
  let component: BoListComponent;
  let fixture: ComponentFixture<BoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
