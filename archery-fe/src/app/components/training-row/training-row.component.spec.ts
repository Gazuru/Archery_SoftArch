import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingRowComponent } from './training-row.component';

describe('TrainingRowComponent', () => {
  let component: TrainingRowComponent;
  let fixture: ComponentFixture<TrainingRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainingRowComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrainingRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
