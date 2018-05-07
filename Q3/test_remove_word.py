import unittest
import remove_word as func

class TestRemoveWord(unittest.TestCase):

    def test_simple(self):
        self.assertEqual(func.removeWordFromSentence("Hello there world.", "there"), "Hello  world.")

    def test_longer(self):
        self.assertEqual(func.removeWordFromSentence("To determine a floodplain boundary, we first identify a “storm event” that concerns us. ", "floodplain"), "To determine a  boundary, we first identify a “storm event” that concerns us. ")

    def test_go(self):
        self.assertEqual(func.removeWordFromSentence("Go.", "Go"), ".")

    def test_chinese(self):
        self.assertEqual(func.removeWordFromSentence("我不餓。", "不"), "我餓。")

    def test_French(self):
        self.assertEqual(func.removeWordFromSentence("Je n'ai pas faim.", "pas "), "Je n'ai faim.")

if __name__ == '__main__':
    unittest.main()