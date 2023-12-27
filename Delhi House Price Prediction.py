
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
df=pd.read_csv(r "C:\Users\Star\Desktop\dataScience expotent files\MagicBricks.csv")
df.head()
<bound method NDFrame.head of          Area  BHK  Bathroom      Furnishing                                           Locality  ...     Price         Status   Transaction           Type Per_Sqft
0       800.0    3       2.0  Semi-Furnished                                   Rohini Sector 25  ...   6500000  Ready_to_move  New_Property  Builder_Floor      NaN
1       750.0    2       2.0  Semi-Furnished             J R Designers Floors, Rohini Sector 24  ...   5000000  Ready_to_move  New_Property      Apartment   6667.0
2       950.0    2       2.0       Furnished                Citizen Apartment, Rohini Sector 13  ...  15500000  Ready_to_move        Resale      Apartment   6667.0
3       600.0    2       2.0  Semi-Furnished                                   Rohini Sector 24  ...   4200000  Ready_to_move        Resale  Builder_Floor   6667.0
4       650.0    2       2.0  Semi-Furnished  Rohini Sector 24 carpet area 650 sqft status R...  ...   6200000  Ready_to_move  New_Property  Builder_Floor   6667.0
...       ...  ...       ...             ...                                                ...  ...       ...            ...           ...            ...      ...
1254   4118.0    4       5.0     Unfurnished                                  Chittaranjan Park  ...  55000000  Ready_to_move  New_Property  Builder_Floor  12916.0
1255   1050.0    3       2.0  Semi-Furnished                                  Chittaranjan Park  ...  12500000  Ready_to_move        Resale  Builder_Floor  12916.0
1256    875.0    3       3.0  Semi-Furnished                                  Chittaranjan Park  ...  17500000  Ready_to_move  New_Property  Builder_Floor  12916.0
1257    990.0    2       2.0     Unfurnished                          Chittaranjan Park Block A  ...  11500000  Ready_to_move        Resale  Builder_Floor  12916.0
1258  11050.0    3       3.0     Unfurnished                                  Chittaranjan Park  ...  18500000  Ready_to_move  New_Property  Builder_Floor  12916.0

df.shape
(1259, 11)
df.isnull().sum()
Area             0
BHK              0
Bathroom         2
Furnishing       5
Locality         0
Parking         33
Price            0
Status           0
Transaction      0
Type             5
Per_Sqft       241
dtype: int64

df['Per_Sqft']=df['Per_Sqft'].fill(df['Price']/df['Area'])

df['Parking'].fillna(df['Parking'].mode()[0],inplace=True)
df['Bathroom'].fillna(df['Bathroom'].mode()[0],inplace=True)
df['Furnishing'].fillna(df['Furnishing'].mode()[0],inplace=True)
df['Type'].fillna(df['Type'].mode()[0],inplace=True)
Area           0
BHK            0
Bathroom       0
Furnishing     0
Locality       0
Parking        0
Price          0
Status         0
Transaction    0
Type           0
Per_Sqft       0
dtype: int64
df.dtypes
Area           float64
BHK              int64
Bathroom       float64
Furnishing      object
Locality        object
Parking        float64
Price            int64
Status          object
Transaction     object
Type            object
Per_Sqft       float64
dtype: object
>>> df[['Parking','Bathroom']].astype('int64')
      Parking  Bathroom
0           1         2
1           1         2
2           1         2
3           1         2
4           1         2
...       ...       ...
1254        3         5
1255        3         2
1256        3         3
1257        1         2
1258        1         3

df.nunique()//unique value count
Area           315
BHK              8
Bathroom         7
Furnishing       3
Locality       365
Parking          9
Price          284
Status           2
Transaction      2
Type             2
Per_Sqft       433
dtype: int64

 print (df['Area'].value_counts(),'\n',df['BHK'].value_counts(),'\n',df['Bathroom'])
Area
900.0      67
1500.0     50
1800.0     48
1000.0     42
1600.0     38
           ..
150.0       1
3250.0      1
4000.0      1
5500.0      1
11050.0     1
Name: count, Length: 315, dtype: int64
 BHK
3     541
2     367
4     220
1      96
5      27
6       6
7       1
10      1
Name: count, dtype: int64
 0       2.0
1       2.0
2       2.0
3       2.0
4       2.0
       ...
1254    5.0
1255    2.0
1256    3.0
1257    2.0
1258    3.0
Name: Bathroom, Length: 1259, dtype: float64
df['Locality'].unique()
def grp_local(locality):
...                          locality=locality.lower()
...                          if 'rohini'in locality:
...                                                 return 'Rohini Sector'
...                          elif 'dwarka' in locality:
...                                                    return 'Dwarka Sector'
...                          elif 'shahdara' in locality:
...                                                      return 'shahdara Sctor'
...                          else:
...                                return 'others'
... df['Locality']=df['Locality'].apply(grp_local)
  File "<stdin>", line 11
    df['Locality']=df['Locality'].apply(grp_local)
    ^^
SyntaxError: invalid syntax
df['Locality'].value_counts()
Locality
Lajpat Nagar 3
from scipy import stats
 z=np.abs(stats.zscore(df[df.dtypes[df.dtypes!='object'].index]))
 df=df[(z<3).all(axis=1)]
 df.describe()
              Area          BHK     Bathroom      Parking         Price      Per_Sqft   Area_Yards
count  1189.000000  1189.000000  1189.000000  1189.000000  1.189000e+03   1189.000000  1189.000000
mean   1296.421567     2.735913     2.483600     1.410429  1.852459e+07  12629.785274   144.046841
std     750.284776     0.859232     0.952107     0.719913  1.772598e+07   8434.085021    83.364975
min      28.000000     1.000000     1.000000     1.000000  1.000000e+06   1250.000000     3.111111
25%     800.000000     2.000000     2.000000     1.000000  5.510000e+06   6526.000000    88.888889
50%    1150.000000     3.000000     2.000000     1.000000  1.350000e+07  10943.000000   127.777778
75%    1600.000000     3.000000     3.000000     2.000000  2.490000e+07  16584.000000   177.777778
max    5220.000000
df.head(5)
 
    Area  BHK  Bathroom      Furnishing                                           Locality  ...         Status   Transaction           Type Per_Sqft  Area_Yards
0  800.0    3       2.0  Semi-Furnished                                   Rohini Sector 25  ...  Ready_to_move  New_Property  Builder_Floor   8125.0   88.888889
1  750.0    2       2.0  Semi-Furnished             J R Designers Floors, Rohini Sector 24  ...  Ready_to_move  New_Property      Apartment   6667.0   83.333333
2  950.0    2       2.0       Furnished                Citizen Apartment, Rohini Sector 13  ...  Ready_to_move        Resale      Apartment   6667.0  105.555556
3  600.0    2       2.0  Semi-Furnished                                   Rohini Sector 24  ...  Ready_to_move        Resale  Builder_Floor   6667.0   66.666667
4  650.0    2       2.0  Semi-Furnished  Rohini Sector 24 carpet area 650 sqft status R...  ...  Ready_to_move  New_Property  Builder_Floor   6667.0   72.222222

[5 rows x 12 columns]
sns.histplot(x=df['Area_Yards'],kde=True,bins=50).set_title('Area in yards')
Text(0.5, 1.0, 'Area in yards')
 sns.countplot(x='Furnishing',data=df).set_title('Furnishing')
Text(0.5, 1.0, 'Furnishing')
>>> plt.show()
sns.countplot(x='Parking',data=df).set_title('Parking')
Text(0.5, 1.0, 'Parking')
>>> plt.show()
sns.countplot(x='Status',data=df).set_title('Status of the Property')
Text(0.5, 1.0, 'Status of the Property')
>>> plt.show()
sns.countplot(x='Transaction',data=df).set_title('Transaction type')
Text(0.5, 1.0, 'Transaction type')
>>> plt.show()
sns.countplot(x='Type',data=df).set_title('Type of house')
Text(0.5, 1.0, 'Type of house')
>>> plt.show()
sns.scatterplot(x='Area_Yards',y='Price',data=df)
<Axes: xlabel='Area_Yards', ylabel='Price'>
>>> plt.show()
sns.boxplot(x='BHK',y='Price',data=df).set_title('BHK vs Price')
Text(0.5, 1.0, 'BHK vs Price')
>>> plt.show()
 sns.boxplot(x='Bathroom',y='Price',data=df).set_title('bathroom vs Price')
Text(0.5, 1.0, 'bathroom vs Price')
>>> plt.show()
sns.boxplot(x='Parking',y='Price',data=df).set_title('Parking vs price')
Text(0.5, 1.0, 'Parking vs price')
>>> plt.show()
Locality and price
 sns.boxplot(x='Locality',y='Price',data=df).set_title('location vs price')
Text(0.5, 1.0, 'location vs price')
>>> plt.xticks(rotation=90)
 sns.boxplot(x='Furnishing',y='Price',data=df).set_title('furshing vs price')
Text(0.5, 1.0, 'furshing vs price')
>>> plt.show()
status and price
sns.boxplot(x='Status',y='Price',data=df).set_title('stsus vs price')
Text(0.5, 1.0, 'stsus vs price')
>>> plt.show()
sns.boxplot(x='Type',y='Price',data=df).set_title('Price vs Type')
Text(0.5, 1.0, 'Price vs Type')
>>> plt.show()
>>>

>>>

 
