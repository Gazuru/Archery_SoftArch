import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoundAddComponent } from './round-add.component';

describe('RoundAddComponent', () => {
  let component: RoundAddComponent;
  let fixture: ComponentFixture<RoundAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoundAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RoundAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
