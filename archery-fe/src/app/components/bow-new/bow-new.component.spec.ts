import {ComponentFixture, TestBed} from '@angular/core/testing';

import {BowNewComponent} from './bow-new.component';

describe('BowNewComponent', () => {
  let component: BowNewComponent;
  let fixture: ComponentFixture<BowNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BowNewComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(BowNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
