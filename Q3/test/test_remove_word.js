var func = require('../remove_word');
var assert = require('assert');

describe('remove word from sentence', function() {
  describe('happy path', function() {
    it('simple case', function() {
      console.time('duration');
      assert.equal(func.removeWordFromSentence("Hello big world", "big"), "Hello  world");
      console.timeEnd('duration');
    });
  });
  describe('edge case', function() {
    it('longer with punctuation', function() {
      console.time('duration');
      assert.equal(func.removeWordFromSentence("To determine a floodplain boundary, we first identify a “storm event” that concerns us. ", "floodplain"), "To determine a  boundary, we first identify a “storm event” that concerns us. ");
      console.timeEnd('duration');
    });
  });
  describe('edge case', function() {
    it('single word', function() {
      console.time('duration');
      assert.equal(func.removeWordFromSentence("Go.", "Go"), ".");
      console.timeEnd('duration');
    });
  });  
  describe('i18n', function() {
    it('traditional Chinese', function() {
      console.time('duration');
      assert.equal(func.removeWordFromSentence("我不餓。", "不"), "我餓。");
      console.timeEnd('duration');
    });
  });
  describe('i18n', function() {
    it('French', function() {
      console.time('duration');
      assert.equal(func.removeWordFromSentence("Je n'ai pas faim.", "pas "), "Je n'ai faim.");
      console.timeEnd('duration');
    });
  });
});