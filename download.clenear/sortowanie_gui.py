import tkinter as tk
from tkinter import filedialog, messagebox
from sortowanie_logika import sortuj_pliki

class SortowanieAplikacja:
    def __init__(self, master):
        self.master = master
        master.title("Aplikacja do sortowania plików")

        self.label = tk.Label(master, text="Wybierz folder Pobrane:")
        self.label.pack()

        self.folder_button = tk.Button(master, text="Wybierz folder", command=self.wybierz_folder)
        self.folder_button.pack()

        self.sortuj_button = tk.Button(master, text="Sortuj pliki", command=self.sortuj_pliki)
        self.sortuj_button.pack()

    def wybierz_folder(self):
        folder_pobrane = filedialog.askdirectory()
        self.label.config(text=f"Wybrany folder: {folder_pobrane}")
        self.folder_pobrane = folder_pobrane

    def sortuj_pliki(self):
        if hasattr(self, 'folder_pobrane'):
            sortuj_pliki(self.folder_pobrane)
            messagebox.showinfo("Sukces", "Pliki zostały posortowane!")
        else:
            messagebox.showwarning("Błąd", "Proszę wybrać folder Pobrane przed sortowaniem.")
