import {ComponentFixture, TestBed} from '@angular/core/testing';

import {StudentWorkbenchComponent} from './student-workbench.component';

describe('StudentWorkbenchComponent', () => {
  let component: StudentWorkbenchComponent;
  let fixture: ComponentFixture<StudentWorkbenchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudentWorkbenchComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentWorkbenchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
