import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from pandas import DataFrame
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
from sklearn import metrics


gld_data_analysis = pd.read_csv('gld_price_data.csv')


# Convert 'Date' to datetime format
gld_data_analysis['Date'] = pd.to_datetime(gld_data_analysis['Date'])


# Drop 'Date' before calculating correlation
gld_data_analysis_numeric = gld_data_analysis.drop(['Date'], axis=1)


correlation: DataFrame = gld_data_analysis_numeric.corr()
gld_data_analysis.head()
gld_data_analysis.tail()
gld_data_analysis.shape
gld_data_analysis.info()
gld_data_analysis.isnull().sum()
gld_data_analysis.describe()
correlation = gld_data_analysis.corr()
# constructing a heatmap to understand the correlatiom
plt.figure(figsize=(8, 8))
sns.heatmap(correlation, cbar=True, square=True, fmt='.1f', annot=True, annot_kws={'size': 8}, cmap='Blues')
# correlation values of GLD
print(correlation['GLD'])
# checking the distribution of the GLD Price
sns.displot(gld_data_analysis['GLD'], color='green')
X = gld_data_analysis.drop(['Date', 'GLD'], axis=1)
Y = gld_data_analysis['GLD']
print(X)
print(Y)
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=2)
regressor = RandomForestRegressor(n_estimators=100)
# training the model
regressor.fit(X_train, Y_train)
# prediction on Test Data
test_data_prediction = regressor.predict(X_test)
print(test_data_prediction)
# R squared error
error_score = metrics.r2_score(Y_test, test_data_prediction)
print("R squared error : ", error_score)
Y_test = list(Y_test)
plt.plot(Y_test, color='blue', label='Actual Value')
plt.plot(test_data_prediction, color='green', label='Predicted Value')
plt.title('Actual Price vs Predicted Price')
plt.xlabel('Number of values')
plt.ylabel('GLD Price')
plt.legend()
plt.show()

