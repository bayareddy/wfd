import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeementHistoryComponent } from './employeement-history.component';

describe('EmployeementHistoryComponent', () => {
  let component: EmployeementHistoryComponent;
  let fixture: ComponentFixture<EmployeementHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeementHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeementHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
