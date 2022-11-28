import {ComponentFixture, TestBed} from '@angular/core/testing';

import {BowEditComponent} from './bow-edit.component';

describe('BowEditComponent', () => {
  let component: BowEditComponent;
  let fixture: ComponentFixture<BowEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BowEditComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(BowEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
