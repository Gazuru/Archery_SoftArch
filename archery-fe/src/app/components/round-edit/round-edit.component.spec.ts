import {ComponentFixture, TestBed} from '@angular/core/testing';

import {RoundEditComponent} from './round-edit.component';

describe('RoundEditComponent', () => {
  let component: RoundEditComponent;
  let fixture: ComponentFixture<RoundEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RoundEditComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(RoundEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
