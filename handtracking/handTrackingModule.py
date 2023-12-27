import cv2
from cvzone.HandTrackingModule import HandDetector


class HandTracker:
    def __init__(self, maxhands=2, detectioncon=0.5, trackcon=0.5):
        self.results = None
        self.maxHands = maxhands
        self.detectionCon = detectioncon
        self.trackCon = trackcon
        self.detector = HandDetector(maxHands=self.maxHands, detectionCon=self.detectionCon, trackCon=self.trackCon)

    def handsfinder(self, image, draw=True):
        self.results, image = self.detector.findHands(image)

        if draw:
            self.detector.drawHands(image)
        return image

    def positionfinder(self, image, handno=0, draw=True):
        lmlist = []
        if self.results.multi_hand_landmarks:
            hand = self.results.multi_hand_landmarks[handno]
            for id, lm in enumerate(hand):
                h, w, c = image.shape
                cx, cy = int(lm[0] * w), int(lm[1] * h)
                lmlist.append([id, cx, cy])
                if draw:
                    cv2.circle(image, (cx, cy), 15, (255, 0, 255), cv2.FILLED)

        return lmlist


def main():
    cap = cv2.VideoCapture(0)
    tracker = HandTracker()

    while True:
        success, image = cap.read()
        image = tracker.handsfinder(image)
        lmlist = tracker.positionfinder(image)
        if len(lmlist) != 0:
            print(lmlist[4])

        cv2.imshow("Video", image)
        cv2.waitKey(1)

if __name__ == "__main__":
    main()
