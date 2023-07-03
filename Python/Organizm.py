from abc import ABC, abstractmethod

class Organizm(ABC):
    def __init__(self):
        self.sila = None
        self.inicjatywa = None
        self.wiek = None
        self.x = None
        self.y = None
        self.symbol = None
        self.poRozmnozeniu = None
        self.nazwa = None
        self.moj = None
        self.czyZyje = None

    @property
    def sila(self):
        return self.__sila
    @sila.setter
    def sila(self, sila):
        self.__sila = sila

    @property
    def inicjatywa(self):
        return self.__inicjatywa

    @property
    def wiek(self):
        return self.__wiek

    @wiek.setter
    def wiek(self, wiek):
        self.__wiek = wiek

    @property
    def x(self):
        return self.__x

    @x.setter
    def x(self, x):
        self.__x = x

    @property
    def y(self):
        return self.__y

    @y.setter
    def y(self, y):
        self.__y = y

    @property
    def symbol(self):
        return self.__symbol

    @property
    def nazwa(self):
        return self.__nazwa

    @property
    def czyZyje(self):
        return self.__czyZyje

    @czyZyje.setter
    def czyZyje(self, value):
        self.__czyZyje = value

    @inicjatywa.setter
    def inicjatywa(self, value):
        self.__inicjatywa = value

    @symbol.setter
    def symbol(self, value):
        self.__symbol = value

    @nazwa.setter
    def nazwa(self, value):
        self.__nazwa = value

    @abstractmethod
    def akcja(self):
        pass

    @abstractmethod
    def kolizja(self):
        pass

    def obrona(self, atakujacy):
        return False

    def wiek_wzrasta(self):
        self.wiek += 1


    @abstractmethod
    def generator(self, x, y):
        pass
